window.onload = async () => {
    console.log('board2.js ...');

    await imageCall(12);
}



async function apiCall() {

    const url = 'http://localhost:8080/board/save';

    console.dir(document.getElementById('fileList'))
    console.dir(document.getElementById('fileList').files)

    let formData = fnSerialize('myForm');
    console.dir(formData);

    for (let row of formData) {
        console.log(row);
    }

    const result = await apiFormPost(url, formData);
    console.log(result);

}



async function imageCall(fileId) {

    const url = 'http://localhost:8080/file/12';

    // const result =  await (await apiGet(url)).blob();
    // console.log(result);

    const imgTag = `<img src="/file/${fileId}">`;
    document.getElementById('append').innerHTML = imgTag;

}




