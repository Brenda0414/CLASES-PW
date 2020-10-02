     function hola (name="Brenda"){
         console.log("Hello"+ name);
        //  alert(`Hello ${name}`);
     }

     hola();

     function hello(callback){
         console.log("Hello");
         callback();
     }

     function world(){
         console.log("World");
     }
     hello(world);

     let suma= (a,b) => a + b;
     console.log(suma(5,3));

//= Asignacion
//== Comparacion de Valor
//=== Comparacion de valor y tipo de objeto sea el mismo

//AJAX 
    //  var req= new XMLHttpRequest(); // objeto
    //  req.onreadystatechange= function(){
    //      if(this.readyState === 4 && this.status ===200 ){
    //          console.log(this.responseText);
    //      }
    //  }

    // req.open('GET','https://  ');
    // req.send();



    //try{}
    //catch{}
    //finally{}