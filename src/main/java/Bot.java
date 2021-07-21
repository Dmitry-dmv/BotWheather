import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;


import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;





    public class Bot extends TelegramLongPollingBot {
        private static final String BOT_NAME = "MyTestVibenarBot";
        private static final String BOT_TOKEN = "1921525736:AAGBW11FB3TKJnvaVviVfJubv6YdT0ZZBl8";
        private final Queue<Update> queue = new ConcurrentLinkedQueue<>();

        public Bot() {
            super();
        }

        @Override
        public void onUpdateReceived(Update update) {
            queue.add(update);
        }

        @Override
        public String getBotUsername() {
            return BOT_NAME;
        }

        @Override
        public String getBotToken() {
            return BOT_TOKEN;
        }
        public Queue<Update> getQueue(){
            return queue;
        }
    }

