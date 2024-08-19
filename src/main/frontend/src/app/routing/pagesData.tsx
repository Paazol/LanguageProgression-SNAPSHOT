import { routerType } from "../types/router.types";
import Login from "./login";
import Home from "./home";

const pagesData: routerType[] = [
    {
        path: "/",
        element: <Home />,
        title: "home"
    },
    {
        path: "/login",
        element: <Login />,
        title: "Login"
    }
];

export default pagesData;