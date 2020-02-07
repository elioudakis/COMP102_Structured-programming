//COMP102
//elioudakis
//1h askisi
//Thema A

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
            //  tmp2->next=tmp1;
            }
            tmp2->next=tmp1;
        }
        i++;
        }
    return headList;
}


void printList (struct list *l){
    printf("The list of the integers is the following: \n");
    while (l!=NULL){
        printf("%d ", l->value);
        l=l->next;
    }
    printf("\n");
}

void findAndPushBack(int n, struct list **node){
    struct list *tmp=*node;
    struct list *p1=NULL;
    struct list *p2=NULL;
    struct list *p3=NULL;
    struct list *last=NULL;
    int found=0;
    while(tmp->next!=NULL){
        if(tmp->value==n && tmp->next!=NULL && tmp->next->value > n){  //found, the next is bigger, not last
            printf("The number was found.\n");
            p1=tmp;
            p2=tmp->next;

            if(tmp==*node){
                *node=tmp->next;
                while(p2->next!=NULL){
                    p2=p2->next;
                }//we have reached the last node
                p2->next=p1;
                p1->next=NULL;
                found=1;
                break;
            }
            else{
                p3=*node;
                while(p3->next!=tmp){
                    p3=p3->next;
                }//p3 is placed before tmp
                p3->next=tmp->next;
                last=*node;
                while(last->next!=NULL){
                    last=last->next;
                }
                last->next=tmp;
                tmp->next=NULL;
                found=1;
                break;

        }
        }
        else if (tmp->value==n && tmp->next!=NULL && tmp->next->value <n ){ // found, the next is smaller, not last
            printf("The number is in the list, but the next is smaller.\n");
            found=1;
        }
        tmp=tmp->next;
    }


    //if it is at the last node
    if(found==0 && tmp->value==n && tmp->next==NULL){
            printf("The number is the last of the list!\n");
            found=1;
    }

    //if it is not found
    if(found==0){
        printf("The number was not found in the list!\n");
    }
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

    int N;
    printf("Give the number of integers you want to register in the list:");
    scanf("%d", &N);

    head=makeNodes(N);
    printList(head);

    int n;
    printf("Give an integer to use the function findAndPushBack:");
    scanf("%d", &n);
    findAndPushBack(n, &head);
    printList(head);

    //free the list
	freeList(head);


 return 0;
}
