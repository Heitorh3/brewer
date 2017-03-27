# Brewer

Este arquivo versa sobre as peculiaridades do sistema. 

### Detalhes do sistema! ###

* Quick summary
* Version 1.0.0-SNAPSHOT
* [Repositório github dor projeto](https://github.com/Heitorh3/brewer.git)
* Sistema desenvolvido em Java 1.8 Spring MVC - 4.3.0.RELEASE + Bootstrap 3 + Thymelead - 3.0.3.RELEASE com um layout responsivo e banco de dados Mysql.

### Configurações do projeto ##

#### Instruçõe de como configurar o jRebel
	Propriedade que deve ser adicionando no arquivo de configuração apontando para o workspace do eclipse.
	rebel.project.path=C:\\Users\\Heitor\\Documents\\Desenvolvimento\\
	
	Localização do arquivo de propriedade do jRebel - (jrebel.properties)
	C:\Users\Heitor\.jrebel
	
	Parametro que deve ser adicionado no arquivo rebel.xml 
	
	${rebel.project.path} 
		
	Abaixo tem um exemplo de como o arquivo deve ficar.
		
	<classpath>
		<dir name="${rebel.project.path}\brewer\target\classes">
		</dir>
	</classpath>

	<web>
		<link target="/">
			<dir name="${rebel.project.path}\brewer\src\main\webapp">
			</dir>
		</link>
	</web>
		
		

#### Plugin Thymelead para eclipse 
	Nome: Thymeleaf Eclipse Plugin
	URL: http://www.thymeleaf.org/eclipse-plugin-update-site/


#### Layout do projeto 
	http://alga.works/sws-layout
	
	


### Contatos ###

* Heitor Carvalho de Almeida Neto heitorh3@gmail.com