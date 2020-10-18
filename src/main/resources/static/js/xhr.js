async function asyncXhrProm() {
    let promise = new Promise(function (resolve, reject) {
        const requestURL = 'http://localhost:8080/temp'
        const xhr = new XMLHttpRequest()
        xhr.open('GET', requestURL)    //open new connection
        xhr.responseType = 'json'
        xhr.send()
        xhr.onload = () => resolve(xhr.response.temperature);
        xhr.onerror = () => reject(new Error(`Ошибка загрузки скрипта `));
        //xhr.onerror= ()=>function() {alert("Запрос не удался");
    })
    let result = await promise;
    console.log(result);
    //console.log(typeof (result));

    return result
}
let r;
function getTemp(){
    asyncXhrProm().then((temp)=>r=temp)
    return r;
}