package com.catchtable.clone.domain.terms;

import com.catchtable.clone.infrastructure.terms.TermsStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TermsServiceImpl implements TermsService {
    private final TermsStore termsStore;

    @Override
    public TermsInfo registerTerms(TermsCommand termsCommand) {
        var initTerms = termsCommand.toEntity();
        Terms terms = termsStore.store(initTerms);
        return null;
    }
}
