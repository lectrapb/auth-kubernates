# AUTH-KUBERNATES

Today, Kubernetes is one of the most popular technologies used to deploy web services; in this article, I will briefly introduce how to build a deployment for a Java web service with Kubernetes. 

## DEPLOY

## Requirements to deploy
1. You have to be installed the applications <a href="https://docs.docker.com/engine/install/"> Docker </a>, <a href="https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/"> Kubectl </a> and <a href="https://minikube.sigs.k8s.io/docs/start/"> Minikube </a>.
2. The backend was developed in java with the Ide <a href="https://www.jetbrains.com/idea/download/#section=windows"> IntelliJ IDEA</a> (optional).
3. Any console to command line...

## Get started
1. Use the command "minikube start". 
2. Get into the folder deployment and use the command "kubectl apply -f deployment-auth.yaml".
3. Use the command "kubectl get pods".
4. Import Postman <a href="https://github.com/lectrapb/auth-kubernates/tree/main/documentation/Postman">  collection </a> and test it!.