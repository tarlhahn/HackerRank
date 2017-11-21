We're going to make our own Contacts application! The application must perform two types of operations:

1. add name, where name is a string denoting a contact name. This must store name as a new contact in the application.
2. find partial, where partial is a string denoting a partial name to search the application for. It must count the number of contacts starting with partial and print the count on a new line.

Given n sequential add and find operations, perform each operation in order.

Constraints
# 1 <= n <= 10^5
# 1 <= |name| <= 21
# 1 <= |partial| <= 21
# It is guaranteed that name and partial contain lowercase English letters only
# The input doesn't have any duplicate name for the add operation.