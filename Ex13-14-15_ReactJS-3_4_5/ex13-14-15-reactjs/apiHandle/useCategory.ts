import { useFetch, usePost, useDelete, useUpdate } from "./utils/useReactQuery";
import { apiBaseUrl, getApiResponseData } from "./constant";

export const useGetAllCategory = () => {
    const result = useFetch(`${apiBaseUrl}/categories`, {}, {});
    return getApiResponseData(result);
}

export const useGetCategory = (id: any) => {
    const result = useFetch(`${apiBaseUrl}/categories/${id}`, {}, {});
    return getApiResponseData(result);
}

export const useCreateCategory = ({onSuccess, onError}: any) => {
    return usePost(`${apiBaseUrl}/categories`, {}, () => {}, {onSuccess, onError});
}

export const useDeleteCategory = ({onSuccess, onError}: any) => {
    return useDelete(`${apiBaseUrl}/categories`, {},() => {}, {onSuccess, onError})
}

export const useUpdateCategory = (id: any, {onSuccess, onError}: any) => {
    return useUpdate(`${apiBaseUrl}/categories/update/${id}`, {id: id}, () =>{}, {onSuccess, onError})
}

export const useGetPageSize = (page: any, size: any) => {
    const result = useFetch(`${apiBaseUrl}/categories/page_size`, {page: page, size: size}, {});
    return getApiResponseData(result)
}

export const useGetCategoryInPage = (page: any, size: any) => {
    const result = useFetch(`${apiBaseUrl}/categories/page`, {page: page, size: size}, {});
    return getApiResponseData(result)
}