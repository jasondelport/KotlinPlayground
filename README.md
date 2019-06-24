# KotlinPlayground

Add the following to ~/.bash_profile     

`
export PATH=/usr/local/bin/kotlin:$PATH
function kotlinr() {
  echo Compiling, please wait...
  kotlinc $1 -include-runtime -d out.jar
  java -jar out.jar
}
`

kotlinr src/hello.kt    