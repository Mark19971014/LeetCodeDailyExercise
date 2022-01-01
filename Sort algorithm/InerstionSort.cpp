// leetCode 2021.1.1 
#include <iostream>
 struct ListNode {
     int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };
 
class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
        // list pointer always point to the first element of data structure
        ListNode* sorted = NULL;
        while(head != NULL){
            ListNode* temp = head;
            head = head->next;
        // 直接插于sorted list
            if(sorted == NULL || sorted->val > temp->val){
                // 插 temp node 于sorted list 头部
                temp->next = sorted;
                // 更新sorted node
                sorted = temp;
            }
            else{
                // 在sorted list 中间插
                ListNode* cur = sorted;
            while(cur->next != NULL && cur->next->val < temp->val){
                // 比大小 找位置
                cur = cur->next;
            }
            // temp 的下一个 是原cur的下一个
                temp->next = cur->next;
            //原cur的下一个 改为指向temp
                cur->next = temp;
            }
        }
        return sorted;
    }
};