$responseStatus = '400'

while ($responseStatus.ToString()[0] -ne '2') {
    Start-Sleep -Seconds 5

    try {
        $response = Invoke-WebRequest -Uri "http://localhost:8083/connectors" -UseBasicParsing
    } catch {
        $response = '400'
        Write-Output "Container is not ready. Waiting 5 seconds..."
        continue;
    }

    $responseStatus = $response.StatusCode

    if($responseStatus.ToString()[0] -ne '2'){
        Write-Output "Container is not ready. Waiting 5 seconds..."
    } else {
        Write-Output "Container is ready. Continue..."
    }
}
