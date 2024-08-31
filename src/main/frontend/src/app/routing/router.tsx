import { Route, Routes } from "react-router-dom";
import { routerType } from "./router.types";
import pagesData from "./pagesData";

const Router = () => {
    const pageRoutes = pagesData.map(({title, path, element }: routerType) => {
        return <Route key={title} path={path} element={element} />;
    });

    return <Routes>{pageRoutes}</Routes>;
};

export default Router;