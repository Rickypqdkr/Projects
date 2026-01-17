const textArea = document.querySelector(".text-area");
const msn = document.querySelector(".message");
// Get references to the text areas and the "Copy" button
const inputTextArea = document.querySelector(".text-area");
const outputTextArea = document.querySelector(".message");
const copyButton = document.querySelector(".btn-copy");
//************************* Functions ************************** */
function code(strcode){
    let matrizCodigo =[["e","enter"],["i","imes"],["a","ai"],["o","ober"],["u","ufat"]];
    //console.table(matrizCodigo);
    strcode = strcode.toLowerCase();//** Convert words to lowercase */
    for(let i =0; i<matrizCodigo.length;i++){
        if(strcode.includes(matrizCodigo[i][0])){
            strcode = strcode.replaceAll(matrizCodigo[i][0], matrizCodigo[i][1]); //** replace letters  */
        }
    }
    return strcode;
}

function decode(strdecode){
    let matrizCodigo =[["e","enter"],["i","imes"],["a","ai"],["o","ober"],["u","ufat"]];
    //console.table(matrizCodigo);
    strdecode = strdecode.toLowerCase();//** Convert words to lowercase */

    for(let i =0; i< matrizCodigo.length; i++){
        if(strdecode.includes(matrizCodigo[i][1])){
            strdecode = strdecode.replaceAll(matrizCodigo[i][1], matrizCodigo[i][0]); //** replace letters  */
        }
    }
    return strdecode;

}


//***** Functions Btns */

function btnCode(){
    const txtcode = code(textArea.value);
    msn.value = txtcode;
    textArea.value = "";
    msn.style.backgroundImage = "none";
}

function btnDecode(){
    const txtcode = decode(textArea.value);
    msn.value = txtcode;
    textArea.value = "";
    msn.style.backgroundImage = "none";
}

function btn_copy(){
    
    outputTextArea.value = inputTextArea.value;
}
