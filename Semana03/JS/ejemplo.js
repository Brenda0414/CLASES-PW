//SCOPE GLOBAL
//SCOPE BLOQUE

function hola(){
   
    if(true){ 
        //global
        var hello= "Hola";
    console.log(hello);
         //bloque
        let adios= "Adios";
        console.log(adios);
    }
    console.log(hello);
    adios();
    console.log(adios);
}

function adios(){
    const hello = "test";
    console.log(hello);
}

function dataType()
{
    let number=5;
    console.log(number + "2");
    console.log(number * "2");
    console.log(number + +"2");
    console.log(number + -"2");
}

function ciclos(){
let numbers = [5,1,7,9,5,4,3,8,7,6,8,4];
console.log("FOR");
for(let i=0;i <numbers.length;i++){
    // console.log("INDICES");
    // console.log(i);
    // console.log("VALORES");
    console.log(numbers[i]);
}
console.log("FOR IN"); //INDICE
for(const number in numbers){
console.log(number);
}

console.log("FOR OF"); // VALORES
for(const number of numbers){
console.log(number);
}

}

// hola();
// adios();
// dataType();
ciclos();