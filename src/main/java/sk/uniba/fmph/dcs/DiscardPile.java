package sk.uniba.fmph.dcs;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class DiscardPile {
    private List<CardInterface> cards;

    public DiscardPile(List<CardInterface> _cards) {
        cards = _cards;
    }

    public Optional<CardInterface> getTopCard() {
        if (cards.isEmpty()) return Optional.empty();
        return Optional.of(cards.get(cards.size() - 1));
    }

    public void addCards(List<CardInterface> _cards) {
        cards.addAll(_cards);
    }

    public void addCard(CardInterface card) {
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }

    public List<CardInterface> shuffle() {
        Collections.shuffle(cards);
        List<CardInterface> cards_to_send = cards;
        cards = new ArrayList<>();
        return cards_to_send;
    }

    public int getPoints() {
        int points = 0;
        for (CardInterface card : cards) {
            points += card.cardType().getPoints();
        }
        return points;
    }
}