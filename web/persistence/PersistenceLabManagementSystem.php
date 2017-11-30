<?php
require_once __DIR__.'../../model/URLMS.php';

class PersistenceLabManagementSystem{
	private $filename;
	
	function __construct($filename = 'tmp/data.txt'){
		$this->filename = $filename;
	}
	
	function loadDataFromStore(){
		if (file_exists($this->filename)){
			$str = file_get_contents($this->filename);
			$urlms = unserialize($str);
		} else {
			$urlms = URLMS::getInstance();
		}
		return $urlms;
	}
	
	function writeDataToStore($urlms){
		$str = serialize($urlms);
		file_put_contents($this->filename, $str);
	}
	
}
?>