function showTitle(){
let title= $('#title');
//$('#title').show();
title.show();
}

function hideTitle(){
    let title= $('#title');
    //$('#title').hide();
     title.hide();
}

function deleteTitle(){
    // $('.titles').remove();
    $('div > .titles:nth-of-type(1)').remove();
}

function createTitle(){
    $('#titles').append('<h2 class = "titles"> Titles</h2>');
}

function fetchData(){
    //llamada asincrona AJAX
    $.ajax({method: 'GET',
            url: 'https://api.openbrewerydb.org/breweries'
        }).done(function(data){
            let container = $('#breweries');
console.log(data);
$.each(data,(k,v) => {
    console.log(v);
    container.append(`<div class="brewery-block">
    <h2>Name: ${v.name}</h2>
    <p>State: ${v.state}</p>
    <p>City:  ${v.city}</p>
    <p>Web:   ${v.website_url}</p>
    </div>
    `);

});
            });
}

//window.onload

$(function(){
    // alert('Ya cargo todo');

});


