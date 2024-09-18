/* 
compiler flags used, is any: <gcc -std=c99>  
*/

#include <stdio.h> 
int main(){
int height = 5;
int h;
int i,j;
char sym = '*';
char menu;
char sym2;
int G,g,N,n,S,s,Q,q;

while(menu!='q' || menu!='Q') {
  for(i=1;i<=height;i++){
    for(j=1;j<=height - i ;j++){
      printf(" ");
    }
      for(j=1;j<=i; j++){
        printf("%c ",sym);
      }
    printf("\n");
  }
  printf("Select:\n G: Grow the currect triangle\n S: Shrink the currect triangle  \n N: Draw new triangle\n Q: Quit\n");
  scanf(" %c", &menu);


  if(menu == 'g' || menu == 'G'){
    if(height>=40){
      height = height + 0;
    }
    else {height = height + 1;
    }
  }
  else if( menu == 'q' || menu == 'Q'){
    break;
  }
  else if (menu == 'n' || menu == 'N'){
    printf("enter height: ");
    scanf("%d" , &h);   
    printf("enter character: ");
    scanf(" %c", &sym2);
      if (h <2 || h >40){
        printf("height cannot be entered\n");
        height = height;
        sym = sym;
      }
      else if(sym2!='*' && sym2!='"' && sym2!='#' && sym2!='!' && sym2!='%' &&sym2!='&' && sym2!='$' && sym2!='^'){
        printf("symbol cannot be used\n");
        sym = sym;
        height =  height;
      }
       else{
        height = h;
        sym = sym2;
       }
    }
  else if (menu == 's' || menu == 'S'){
    if(height<=2){
      height = height - 0;
    }
    else {
    height = height - 1;
    }
  }
  else(1);
}
return 0;
}
