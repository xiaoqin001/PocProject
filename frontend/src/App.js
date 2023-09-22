import React from "react";
import HomePage from "./Pages/HomePage.js";
import LoginPage from "./Pages/LoginPage.js";
import { Route, Routes } from "react-router-dom";

function App() {

  return (
    <>
      <div className="app-container">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/Login" element={<LoginPage />} />
        </Routes>
      </div>
    </>
  );
}

export default App
