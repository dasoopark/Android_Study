package kr.co.korearental.retrofit

interface CompletionListener {
    fun loadComplete(data: Data)
    fun responseIsNotSuccesful(code: Int)
    fun loadFail()

}