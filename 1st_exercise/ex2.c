//COMP102
//elioudakis
//1h askisi
//Thema B

#include <stdio.h>
#include <stdlib.h>

struct list{
    int value;
    struct list* next;
};

struct list * makeNodes (int num){
    int i=0, x;
    struct list *headList=NULL;
    struct list *tmp1=NULL;
    struct list *tmp2=NULL;
    while (i<num){
        tmp1=(struct list *)malloc(sizeof(struct list));
        printf("Give an integer:");
        scanf("%d", &x);
        tmp1->value=x;
        tmp1->next=NULL;
        if(headList==NULL){
            headList=tmp1;
        }
        else{
            tmp2=headList;
            while(tmp2->next!=NULL){
                tmp2=tmp2->next;
            }
            tmp2->next=tmp1;
        }
        i++;
        }
    return headList;
}

//For the Step 3 printing
void printList (struct list *l){
    printf("The list of the integers is the following: \n");
    while (l!=NULL){
        printf("%d ", l->value);
        l=l->next;
    }
    printf("\n");
}

int checkModuloOfSum (struct list *node){
    int sum=0;
    if(node==NULL){
        return sum;
    }

    if(node->next==NULL){
        sum=0;
    }
    else{
    sum=node->next->value+checkModuloOfSum(node->next);
    }
    //reverse printing-will be executed after all the calls of checkModuloOfSum
    printf("%d", node->value);
    printf("[%d] ", sum);
    if(sum%node->value==0){
        printf("(Yes)   ");
    }
    else{
        printf("(No)   ");
    }
    return sum;
}

void freeList(struct list *node){
	struct list *tmp = node;

    while(tmp != NULL){
		node = node->next;
		free(tmp);
		tmp = node;
    }
}

int main(){
    struct list *head= NULL;

    int tmp;

    int N;
    printf("Give the number of integers you want to register in the list:");
    scanf("%d", &N);

    head=makeNodes(N);

    //For the Step 3 printing
    printList(head);

    tmp=checkModuloOfSum(head);

    //free the list
	freeList(head);

    return 0;
}
