const container = document.getElementById("container");
document.addEventListener("DOMContentLoaded", function () {
  const md = window.markdownit();
  container.innerHTML = md.render(container.innerText);

  renderMathInElement(document.body, {
    // customised options
    // • auto-render specific keys, e.g.:
    delimiters: [
      { left: "$$", right: "$$", display: true },
      { left: "$", right: "$", display: false },
      { left: "\\(", right: "\\)", display: false },
      { left: "\\[", right: "\\]", display: true },
    ],
    // • rendering keys, e.g.:
    throwOnError: false,
  });
});

container.contentEditable = true;
