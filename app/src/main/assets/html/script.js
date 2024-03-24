const container = document.getElementById("container");

const md = markdownit({
  highlight: function (str, lang) {
    if (lang && hljs.getLanguage(lang)) {
      try {
        return (
          '<div class="hjljs-container"><pre><code class="hljs">' +
          hljs.highlight(str, { language: lang, ignoreIllegals: true }).value +
          "</code></pre></div>"
        );
      } catch (__) {}
    }

    return (
      '<div class="hjljs-container"><pre><code class="hljs">' +
      md.utils.escapeHtml(str) +
      "</code></pre></div>"
    );
  },
});
