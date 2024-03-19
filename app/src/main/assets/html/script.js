window.WebFontConfig = {
  custom: {
    families: [
      "KaTeX_AMS",
      "KaTeX_Caligraphic:n4,n7",
      "KaTeX_Fraktur:n4,n7",
      "KaTeX_Main:n4,n7,i4,i7",
      "KaTeX_Math:i4,i7",
      "KaTeX_Script",
      "KaTeX_SansSerif:n4,n7,i4",
      "KaTeX_Size1",
      "KaTeX_Size2",
      "KaTeX_Size3",
      "KaTeX_Size4",
      "KaTeX_Typewriter",
    ],
  },
};

const container = document.getElementById("container");
const md = window.markdownit();
const bg = get("bg");
const textColor = get("fg");
document.addEventListener("DOMContentLoaded", function () {
  const md = window.markdownit();
  document.getElementById("container").innerHTML = md.render(
    document.getElementById("container").innerText
  );
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

// Util function to get the url parameter
function get(name) {
  var r = /[?&]([^=#]+)=([^&#]*)/g,
    p = {},
    match;
  while ((match = r.exec(window.location))) p[match[1]] = match[2];
  return p[name];
}

window.onload = function () {
  // set the bg
  document.body.style.background = bg;
  document.body.style.color = textColor;
};
