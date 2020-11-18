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

11. 


