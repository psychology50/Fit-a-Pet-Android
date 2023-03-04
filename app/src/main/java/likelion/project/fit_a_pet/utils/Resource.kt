package likelion.project.fit_a_pet.utils

// 봉인된 클래스, 라이프 사이클 주기 동안 응답의 데이터 상태 결정
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String?, data: T? = null) : Resource<T>(data, message)
    // object
    class Loading<T>(data: T? = null) : Resource<T>(data)

}