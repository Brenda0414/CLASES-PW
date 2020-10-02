
function submit(e){
    let formRegistro= document.querySelector("form#registro");
    let message= null;
    addMessage('');
    // formReg.innerHTML = '';
    e.preventDefault();
    console.log(e);
    if(formReg.password.value.lenght < 8){
        formReg.password.classList.add('form-error');
        message = 'Verifique contraseña';
        // addMessage('Verifique Contraseña');
        // displayMessage(true);
    }
    if(formReg.password.value.lenght >= 8){
        formReg.password.classList.remove('form-error');
        // displayMessage(false);
    }
    addMessage(message)
    displayMessage(message);
}

function addMessage(message =''){
    let messageDiv= document.querySelector("div#rmessage-error");
    // messageDiv.append(message);
    messageDiv.innerHTML = message;
}

function displayMessage(show){
    let messageDiv= document.querySelector("div#rmessage-error");
    if(show){
        messageDiv.classList.remove('hide');
    }
    else{
        messageDiv.classList.add('hide');
    }
}

window.onload = function(){
    //let id = document.getElementById("registro");
    let formRegistro= document.querySelector("form#registro");
    let forms = document.forms;
    let formReg= forms.registro;
    // let formReg = forms ['registro'];

console.log(formRegistro);
console.log(forms);
console.log(formReg);

formReg.name.value= "Brenda";
let name = formReg.name.value;
let age = formReg.age.value;
let email = formReg.email.value;
let password = formReg.password.value;
};

