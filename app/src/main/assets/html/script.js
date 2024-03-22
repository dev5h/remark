const container = document.getElementById("container");
document.addEventListener("DOMContentLoaded", function () {
  markdownText = markdownText.replace(/\$\$([^$]+)\$\$/g, function(match, contents) {
    // Escape asterisks
    return match.replace(/\*/g, "\\*");
});
  );
  container.innerHTML = markdownText;
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
