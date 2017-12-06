function ecrirePDF() {
console.log("le bouton a été cliqué")
var agence = $("#Promotion").html();
var printWindow = window.open('', '_blank', 'height=400,width=800');
var is_chrome = Boolean(printWindow.chrome);
// ecrire le html dans la nouvelle fenêtre
printWindow.document.write('<html><head><title>Une offre exceptionnelle</title>');
// printWindow.document.write('<link rel="stylesheet"
// href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
// absolute = true>');
printWindow.document.write('<link type="text/css" rel="stylesheet" href="assets/resources/bootstrap/css/bootstrap.css" />');
printWindow.document.write('<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.js"></script>/>');

printWindow.document.write('</head><body>');

// Add the stylesheet link and inline styles to the new document:
//printWindow.document.write('<link rel="stylesheet" href="resources/css/styleFich.css">');

printWindow.document.write(agence);
printWindow.document.write('</body></html>');

if (is_chrome) {
setTimeout(function() { // wait until all resources loaded
printWindow.document.close();
printWindow.focus();
printWindow.print();
printWindow.close();
}, 250);
} else {
printWindow.document.close();
printWindow.focus();
printWindow.print();
printWindow.close();
}
}
