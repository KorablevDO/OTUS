package org.otus.hw07.atm;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotes;
import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.exception.ATMException;
import org.otus.hw07.atm.storage.Storage;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

/**
 * Применяю паттерн Декоратор, для расширения функционала класса ATM
 */
public class ATMWSImps extends ATMIpl implements ATMWS {
    public ATMWSImps(Storage storage, AlgorithmIssuingBanknotes algorithm) {
        super(storage, algorithm);
    }

    @Override
    public void inputBanknote(Banknote... banknote) {
        if(Optional.ofNullable(banknote).isPresent()) {
            if (banknote.length > 0) {
                super.inputBanknote(banknote);
            }
        }
    }

    @Override
    public Collection<Banknote> outputBanknote(int value) throws ATMException {
        if (value > 0) {
            return super.outputBanknote(value);
        }
        return null;
    }

    @Override
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void setAlgorithm(AlgorithmIssuingBanknotes algorithm) {
        this.algorithm = algorithm;
    }

    public SnapshotATM createSnapshotATM(){
        //TODO тут косяк
        ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).writer().withDefaultPrettyPrinter();
        try {
            String json1 = ow.writeValueAsString(this.storage);
            System.out.println(json1);
            Storage storage1 = new ObjectMapper().readValue(json1, this.storage.getClass());
//            String json2 = ow.writeValueAsString(this.algorithm);
//            System.out.println(json2);
//            AlgorithmIssuingBanknotes algorithmIssuingBanknotes = new ObjectMapper().readValue(json2, this.algorithm.getClass());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SnapshotATM(this, this.storage, this.algorithm);
    }
}
