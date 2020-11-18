## Simple POC using Amazon SQS SNS with simple publish/subscribe

Publish Messages to SNS topic which is inturn subscribed by SQS/Email etc. 

1. Use Amazon SQS to create a simple Queue

![image](https://user-images.githubusercontent.com/61533898/99498387-6077cb80-299d-11eb-8147-c653c3a9a95e.png)

2. Create Transaction Queue

![image](https://user-images.githubusercontent.com/61533898/99504975-3ecf1200-29a6-11eb-9148-112f673dc0a3.png)

3. Transaction queue created

![image](https://user-images.githubusercontent.com/61533898/99505155-776eeb80-29a6-11eb-9ab9-23618efa699e.png)

4. ARN of the queue : ARN = arn:aws:sqs:us-east-2:987099217462:TransactionQueue

5. SNS High level architecture :

![image](https://user-images.githubusercontent.com/61533898/99505252-98cfd780-29a6-11eb-9165-47c57a880fe2.png)

6. Create a Topic

![image](https://user-images.githubusercontent.com/61533898/99506537-3bd52100-29a8-11eb-9ddf-7debe67f61d8.png)

7. Simple Configurations :

![image](https://user-images.githubusercontent.com/61533898/99506637-59a28600-29a8-11eb-83c6-90e77b70c287.png)

8. Topic Created :

![image](https://user-images.githubusercontent.com/61533898/99506698-6d4dec80-29a8-11eb-9870-7accf3c08db5.png)

9. ARN : arn:aws:sns:us-east-2:987099217462:TransactionTopic

10. Create Subscription from SQS queue to SNS topic:

![image](https://user-images.githubusercontent.com/61533898/99506767-89518e00-29a8-11eb-8153-d6f7dd9d7c1b.png)

11. Subscription Created :

![image](https://user-images.githubusercontent.com/61533898/99506941-c74eb200-29a8-11eb-8fa1-bb3785b1ecdb.png)

12. Verify the dashboard :

![image](https://user-images.githubusercontent.com/61533898/99507016-de8d9f80-29a8-11eb-8786-191c5f449220.png)

13. Create permission for SQS queue to subscribe from SNS topic by copying ARN details :

![image](https://user-images.githubusercontent.com/61533898/99507131-ffee8b80-29a8-11eb-85a4-e244f80288b2.png)

14. Subscribe to SNS topic :

![image](https://user-images.githubusercontent.com/61533898/99507214-1ac10000-29a9-11eb-8a05-05695480b0e4.png)

15. Publish a simple message from SNS :

![image](https://user-images.githubusercontent.com/61533898/99507267-2f04fd00-29a9-11eb-9b31-8f6c9d8ae0ab.png)


![image](https://user-images.githubusercontent.com/61533898/99507443-62478c00-29a9-11eb-8505-9891754d007e.png)

![image](https://user-images.githubusercontent.com/61533898/99507521-79867980-29a9-11eb-8778-6a8facb6fae3.png)

16. Validate at SQS end :

![image](https://user-images.githubusercontent.com/61533898/99507562-8acf8600-29a9-11eb-9e47-496253c884d2.png)

![image](https://user-images.githubusercontent.com/61533898/99507601-9ae76580-29a9-11eb-94dd-19948a89af87.png)

![image](https://user-images.githubusercontent.com/61533898/99507630-a3d83700-29a9-11eb-832d-601717338336.png)

![image](https://user-images.githubusercontent.com/61533898/99507664-ae92cc00-29a9-11eb-871a-655489e76a2f.png)

![image](https://user-images.githubusercontent.com/61533898/99507683-b81c3400-29a9-11eb-9b5e-806e375a02f5.png)

17. Create a simple subscription to your EMAIL from SNS :

![image](https://user-images.githubusercontent.com/61533898/99507775-d2eea880-29a9-11eb-9c5e-ed9955f74e70.png)

![image](https://user-images.githubusercontent.com/61533898/99507810-de41d400-29a9-11eb-8dd8-7faf78f168c7.png)


18. Mail Recieved :

![image](https://user-images.githubusercontent.com/61533898/99507865-eef24a00-29a9-11eb-93be-c0592f8fb325.png)


19. Subscriptions :

![image](https://user-images.githubusercontent.com/61533898/99507943-0598a100-29aa-11eb-9297-92e03cc1a182.png)



