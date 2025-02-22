document.addEventListener("DOMContentLoaded", function () {
    const loginContainer = document.getElementById("login-container");
    const signupContainer = document.getElementById("signup-container");

    document.getElementById("show-signup").addEventListener("click", function (event) {
        event.preventDefault();
        loginContainer.classList.add("hidden");
        signupContainer.classList.remove("hidden");
    });

    document.getElementById("show-login").addEventListener("click", function (event) {
        event.preventDefault();
        signupContainer.classList.add("hidden");
        loginContainer.classList.remove("hidden");
    });
});
