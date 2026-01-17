$baseUrl = "http://localhost:8080/api/products"

# Helper function to print headers
function Print-Header ($title) {
    Write-Host ""
    Write-Host "============================" -ForegroundColor Cyan
    Write-Host $title -ForegroundColor Cyan
    Write-Host "============================" -ForegroundColor Cyan
}

# 1. Create Product
Print-Header "1. Creating Product (POST)"
$body = @{
    name = "Laptop Gamer"
    price = 1500.00
    stock = 10
} | ConvertTo-Json

try {
    $response = Invoke-RestMethod -Uri $baseUrl -Method Post -Body $body -ContentType "application/json"
    Write-Host "Product Created: $($response.name) (ID: $($response.id))" -ForegroundColor Green
    $productId = $response.id
} catch {
    Write-Host "Error Creating Product: $_" -ForegroundColor Red
}

# 2. List Products
Print-Header "2. Listing Products (GET)"
try {
    $products = Invoke-RestMethod -Uri $baseUrl -Method Get
    $products | Format-Table id, name, price, stock
} catch {
    Write-Host "Error Listing Products: $_" -ForegroundColor Red
}

# 3. Get Product by ID
if ($productId) {
    Print-Header "3. Get Product by ID (GET $productId)"
    try {
        $product = Invoke-RestMethod -Uri "$baseUrl/$productId" -Method Get
        Write-Host "Found: $($product.name) - $$($product.price)" -ForegroundColor Green
    } catch {
        Write-Host "Error Finding Product: $_" -ForegroundColor Red
    }
}

# 4. Update Product
if ($productId) {
    Print-Header "4. Update Product (PUT $productId)"
    $updateBody = @{
        name = "Laptop Gamer Pro"
        price = 1800.00
        stock = 5
    } | ConvertTo-Json

    try {
        $updated = Invoke-RestMethod -Uri "$baseUrl/$productId" -Method Put -Body $updateBody -ContentType "application/json"
        Write-Host "Updated to: $($updated.name) - $$($updated.price)" -ForegroundColor Green
    } catch {
        Write-Host "Error Updating: $_" -ForegroundColor Red
    }
}

# 5. Validation Error Test
Print-Header "5. Test Validation (POST - Negative Price)"
$invalidBody = @{
    name = "Invalid Product"
    price = -10.00
    stock = 5
} | ConvertTo-Json

try {
    Invoke-RestMethod -Uri $baseUrl -Method Post -Body $invalidBody -ContentType "application/json"
} catch {
    Write-Host "Expected Error Caught: $($_.Exception.Message)" -ForegroundColor Yellow
    # Try to print the detailed error if possible
    # $_.ErrorDetails | Format-List
}

# 6. Delete Product
if ($productId) {
    Print-Header "6. Delete Product (DELETE $productId)"
    try {
        Invoke-RestMethod -Uri "$baseUrl/$productId" -Method Delete
        Write-Host "Product Deleted Successfully" -ForegroundColor Green
    } catch {
        Write-Host "Error Deleting: $_" -ForegroundColor Red
    }
}

# 7. Final List (Should be empty or less one)
Print-Header "7. Final Listing"
try {
    $products = Invoke-RestMethod -Uri $baseUrl -Method Get
    if ($products) {
        $products | Format-Table id, name, price, stock
    } else {
        Write-Host "No products found." -ForegroundColor Yellow
    }
} catch {
    Write-Host "Error Listing: $_" -ForegroundColor Red
}
