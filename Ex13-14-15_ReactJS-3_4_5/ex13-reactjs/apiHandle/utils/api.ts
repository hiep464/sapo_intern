import axios from 'axios';

/**
 * 
 * @param cname name of cookies
 * @returns value cookies
 */
function getCookie(cname: any) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length,c.length);
        }
    }
    return "";
}

/**
 * Utils for api calls
 * Todo: using axios as http client library and js-cookie for token management
 */
export const api = {
    /**
     * @param {string} url
     * @param {object?} params
     * @returns Promise<T>
     */
    get: (url: any, params: any) =>
        axios.get(url, {
            headers: {
                // token: Cookies.get('token'),
            },
            ...params,
        }),

    /**
     * @param {string} url
     * @param {any} data
     * @returns Promise<T>
     */
    post: (url: any, data: any) =>
        axios.post(url, data, {
            headers: {
                // token: Cookies.get('token'),
                Authorization: getCookie("Authorization")
            },
        }),
    /**
     * @param {string} url
     * @param {any} data
     * @returns Promise<T>
     */
    patch: (url: any, data: any) =>
        axios.patch(url, data, {
            headers: {
                // token: Cookies.get('token'),
                Authorization: getCookie("Authorization"),
            },
        }),
    /**
     * @param {string} url
     * @returns Promise<T>
     */
    delete: (url: any) =>
        axios.delete(url, {
            headers: {
                // token: Cookies.get('token'),
                Authorization: getCookie("Authorization"),
            },
        }),
};
