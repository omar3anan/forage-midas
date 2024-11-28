@Service
public class KafkaConsumer {
    private final TransactionService transactionService;

    @Autowired
    public KafkaConsumer(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @KafkaListener(topics = "${kafka.topic.name}")
    public void consume(Transaction transaction) {
        transactionService.processTransaction(transaction);
    }
}
