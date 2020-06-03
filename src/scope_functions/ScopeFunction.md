

### ScopeFunction 

## With()
run() 함수와 거의 같고 receiver가 인자로 오느냐 혹은 현재 객체를 바로 receiver로 넘기냐의 차이다.
run()은 결국
 
 ```kotlin
    someObject.let{
     with(it){
            
        }
    }
```

이런식으로 let() + with()이라고 생각할 수 있다.
 