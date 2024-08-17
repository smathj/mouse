/**
 * 비동기 POST 호출
 */
async function apiPost(url, param) {

    try {
        const option = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(param)
        };

        const result = await (await fetch(url, option)).json();

        return result;
    } catch (e) {
        console.error(e);
    }


}

/**
 * 파일 업로드 및 api 식으로 post 요청
 */
async function apiFormPost(url, form) {

    try {
        const option = {
            method: 'post',
            // headers: {
            //     'Content-Type': 'application/json'
            // },
            body: form
        };

        const result = await (await fetch(url, option)).json();

        return result;
    } catch (e) {
        console.error(e);
    }


}


/**
 * 비동기 GET 호출
 */
async function apiGet(url) {
    const result = await (await fetch(url)).json();
    return result;
}


function fnSerialize(formId) {
  const formTag = document.getElementById(formId);
  const form = new FormData(formTag);
  return form;
}

function fnEnterEvent(targetId, callBack) {
  document
    .getElementById(targetId)
    .addEventListener("keydown", (event) => {
      if (event.code === "Enter" || event.code === "NumpadEnter") {
        callBack();
      }
    });
}