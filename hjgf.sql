
require_once('class.ezpdf.php');
$pdf = new Cezpdf('A4'); 
$pdf->selectFont('fonts/Helvetica.afm');

$bd_host = "localhost:3306";
    $bd_usuario = "root"; 
    $bd_password = "root";
    $bd_base = "ost"; //
        
    $con = mysql_connect($bd_host, $bd_usuario, $bd_password) or die("Error con la conexión"); 
        
    mysql_select_db($bd_base, $con) or die("Error al seleccionar db");
        
    $sql="SELECT id,nombre,paterno,materno FROM alumnos";
        //realizamos nuestra consulta
        $resSql=mysql_query($sql) or die("<br>Error consulta</br>".mysql_error());

