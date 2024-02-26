const container = document.getElementById("container");
const ps = document.querySelectorAll("#container p");
// document.addEventListener("DOMContentLoaded", function () {
//   const md = window.markdownit();
//   container.innerHTML = md.render(container.innerText);

//   renderMathInElement(document.body, {
//     // customised options
//     // • auto-render specific keys, e.g.:
//     delimiters: [
//       { left: "$$", right: "$$", display: true },
//       { left: "$", right: "$", display: false },
//       { left: "\\(", right: "\\)", display: false },
//       { left: "\\[", right: "\\]", display: true },
//     ],
//     // • rendering keys, e.g.:
//     throwOnError: false,
//   });
// });

ps[ps.length - 1].contentEditable = true;
var target_p = null;
// function that process and sets the container
function process_format(content) {}

// record buffer
var buffer = "";
for (var i = 0; i < ps.length; i++) {
  ps[i].onkeyup = function () {
    buffer += container.innerText;
  };
}

// listen for enter event
for (var i = 0; i < ps.length; i++) {
  ps[i].addEventListener("keypress", function (event) {
    if (event.key === "Enter" || event.keyCode === 13 || event.which === 13) {
      process_format(container.inner);
      buffer = "";
    }
  });
}
