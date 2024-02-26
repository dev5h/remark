const container = document.getElementById("container");
const ps = document.querySelectorAll("#container p");

const md = window.markdownit();
// document.addEventListener("DOMContentLoaded", function () {

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

function process_format_unit(rawstr, target) {
  target.innerHTML = md.render(rawstr);
}

ps[ps.length - 1].contentEditable = true;
var target_p = null;
// function that process and sets the container
function process_format(content) {}

// record buffer
var buffer = "";
for (var i = 0; i < ps.length; i++) {
  ps[i].onkeyup = function () {
    buffer += this.innerText;
  };
}

// listen for enter event
for (var i = 0; i < ps.length; i++) {
  ps[i].addEventListener("keypress", function (event) {
    if (event.key === "Enter" || event.keyCode === 13 || event.which === 13) {
      event.preventDefault();
      console.log(this.innerHTML);
      process_format_unit(this.innerText, this);
      buffer = "";
      const child = document.createElement("p");
      container.appendChild(child);
      child.focus();
    }
  });
}
