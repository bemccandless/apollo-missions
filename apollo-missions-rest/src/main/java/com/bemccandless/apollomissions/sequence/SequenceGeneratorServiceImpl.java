package com.bemccandless.apollomissions.sequence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public abstract class SequenceGeneratorServiceImpl implements SequenceGeneratorService {

    private final MongoOperations mongoOperations;

    public Long getSequenceNumber(final String sequenceName) {
        final Query findSequenceGenerator = new Query(Criteria.where("id").is(sequenceName));
        final Update incrementSequenceNumber = new Update().inc("sequence_number", 1);

        final DatabaseSequence databaseSequence = mongoOperations.findAndModify(
                findSequenceGenerator,
                incrementSequenceNumber,
                FindAndModifyOptions.options()
                        .returnNew(true)
                        .upsert(true),
                DatabaseSequence.class);

        return !Objects.isNull(databaseSequence) ? databaseSequence.getSequenceNumber() : 1;
    }
}
