/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Función que pasa a mayúscula los textos
 * @param {type} e
 * @returns {undefined}
 */
function toUpper(e) {
    e.value = e.value.toUpperCase();
}

/**
 * Función que pasa a mayúscula los textos
 * @param {type} e
 * @returns {undefined}
 */
function toLower(e) {
    e.value = e.value.toLowerCase();
}

/**
 * Función que formatea números permitiendo solo números y agregando separadores de miles
 * @param {type} e
 * @returns {undefined}
 */
function format(input) {
    var num = input.value.replace(/\./g, '');
    if (!isNaN(num)) {
        num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g, '$1.');
        num = num.split('').reverse().join('').replace(/^[\.]/, '');
        input.value = num;
    } else {
        //alert('Solo se permiten numeros');
        input.value = input.value.replace(/[^\d\.]*/g, '');
    }
}