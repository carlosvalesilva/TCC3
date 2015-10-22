<?php

	$produto = array(
		array('TRI','Descricao do Trigo','R$ 10,00'),
		array('OL','Descricao do Oleo','R$ 3,00'),
		array('MAR','Descricao do Margarina','R$ 5,00')
		);

	echo "<b>".$produto[0][0]."<b>".$produto[0][1]."<b>".$produto[0][2]."<br/>";

	echo "<hr>";

	for ($lin=0; $lin <3; $lin++) { 
		for ($col=0; $col < 3; $col++) { 
			echo '--'.$produto[$lin][$col];

		}
	echo "<br/>";
	}



?>