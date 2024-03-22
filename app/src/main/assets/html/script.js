const container = document.getElementById("container");

document.addEventListener("DOMContentLoaded", function () {
  // Initialize markdown-it with highlightjs plugin
  // Actual default values
  const md = markdownit({
    highlight: function (str, lang) {
      if (lang && hljs.getLanguage(lang)) {
        try {
          return (
            '<pre><code class="hljs">' +
            hljs.highlight(str, { language: lang, ignoreIllegals: true })
              .value +
            "</code></pre>"
          );
        } catch (__) {}
      }

      return (
        '<pre><code class="hljs">' + md.utils.escapeHtml(str) + "</code></pre>"
      );
    },
  });

  const test = `
  # Hello this is some markdown texts
  Hello world lamo here's a math formula for ya
  ### Hello World I am Shazin 
  Some text with KaTeX syntax: $ E = mc^2 $ and $F = ma$ 
  $x^3$ 
  $$\\int_0^{\\pi/2}  sin^mx+ cos^nx dx$$ 
  Laplacian Transform Well to Do So we do something like below Hello I am

  shazin and you are watching 9xe Hahahaah I and love to do stuffs as well
  lamo
  ## Code Snippet Samples
  Hello
  Here's an \`inline code sample \`
  ### Code
  \`\`\`html
        <!DOCTYPE html>
        <html>
        <head>
            <title>Example</title>
        </head>
        <body>
            <h1>Hello, World!</h1>
        </body>
        </html>
        \`\`\`
  `;
  container.innerHTML = md.render(test);
  // container.innerHTML = marked.parse(container.innerHTML);
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
