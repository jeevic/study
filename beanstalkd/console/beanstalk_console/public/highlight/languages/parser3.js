/*
Language: Parser3
Requires: xml.js
Author: Oleg Volchkov <oleg@volchkov.net>
*/

function(hljs) {
  return {
    defaultMode: {
      subLanguage: 'xml',
      contains: [
        {
          className: 'comment',
          begin: '^#', end: '$'
        },
        {
          className: 'comment',
          begin: '\\^rem{', end: '}',
          relevance: 10,
          contains: [
            {
              begin: '{', end: '}',
              contains: ['self']
            }
          ]
        },
        {
          className: 'preprocessor',
          begin: '^@(?:BASE|USE|CLASS|OPTIONS)$',
          relevance: 10
        },
        {
          className: 'title',
          begin: '@[\\webp\\-]+\\[[\\webp^;\\-]*\\](?:\\[[\\webp^;\\-]*\\])?(?:.*)$'
        },
        {
          className: 'variable',
          begin: '\\$\\{?[\\webp\\-\\.\\:]+\\}?'
        },
        {
          className: 'keyword',
          begin: '\\^[\\webp\\-\\.\\:]+'
        },
        {
          className: 'number',
          begin: '\\^#[0-9a-fA-F]+'
        },
        hljs.C_NUMBER_MODE
      ]
    }
  };
}
