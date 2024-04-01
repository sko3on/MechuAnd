package com.example.mechuand.sqltest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mechuand.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 코루틴을 사용하여 백그라운드에서 HTTP 요청 보내기
        GlobalScope.launch(Dispatchers.IO) {
            val result = fetchDataFromServer()
            // UI 스레드에서 작업을 처리하기 위해 withContext를 사용하여 메인 스레드로 전환
            withContext(Dispatchers.Main) {
                // 여기서는 받은 결과를 텍스트뷰 등으로 표시할 수 있습니다.
                Log.d("HTTP", "Response: $result")
            }
        }
    }

    private suspend fun fetchDataFromServer(): String {
        val result = StringBuilder()
        var connection: HttpURLConnection? = null
        var reader: BufferedReader? = null

        try {
            // 서버 주소 설정
            val url = URL("http://your_server_address/api/data")
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"

            // 응답 받기
            reader = BufferedReader(InputStreamReader(connection.inputStream))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                result.append(line).append("\n")
            }
        } catch (e: Exception) {
            Log.e("HTTP", "Error: ${e.message}")
        } finally {
            // 연결 및 리더 닫기
            connection?.disconnect()
            reader?.close()
        }
        return result.toString()
    }
}

