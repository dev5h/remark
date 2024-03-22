const container = document.getElementById("container");
const md = window.markdownit();

document.addEventListener("DOMContentLoaded", function () {
  const md = window.markdownit();
  document.getElementById("container").innerHTML = md.render(
    document.getElementById("container").innerText
  );
  renderMathInElement(container, {
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
