# Implement three nodes point – to – point network with duplex links between them. Set the queue size, vary the bandwidth and find the number of packets dropped.

set ns [new Simulator]

set ntrace [open 10a.tr w]
$ns trace-all $ntrace
set namfile [open 10a.nam w]
$ns namtrace-all $namfile

proc Finish {} {
	global ns ntrace namfile
	
	$ns flush-trace
	close $ntrace
	close $namfile
	
	exec nam 10a.nam &
	exec echo "The number of packets dropped is " &
	exec grep -c "^d" 10a.tr &
	exit 0
}

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]

$ns color 1 Blue

$n0 label "TCP Source"
$n2 label "Sink"

$ns duplex-link $n0 $n1 1Mb 10ms DropTail
$ns duplex-link $n1 $n2 1Mb 10ms DropTail

$ns duplex-link-op $n0 $n1 orient right
$ns duplex-link-op $n1 $n2 orient right

$ns queue-limit $n0 $n1 10
$ns queue-limit $n1 $n2 10

set tcp0 [new Agent/TCP]
$tcp0 set class_ 1
$ns attach-agent $n0 $tcp0 
set sink0 [new Agent/TCPSink]
$ns attach-agent $n2 $sink0
$ns connect $tcp0 $sink0

set cbr0 [new Application/Traffic/CBR]
$cbr0 set type_ CBR
$cbr0 set packetSize_ 100
$cbr0 set rate_ 1Mb
$cbr0 set random_ false
$cbr0 attach-agent $tcp0

$ns at 0.0 "$cbr0 start"
$ns at 5.0 "Finish"

$ns run


# Output:
# The number of packets dropped is 8
