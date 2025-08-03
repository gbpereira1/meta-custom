SUMMARY = "Create the main user"
LICENSE = "MIT"

inherit extrausers

EXTRA_USERS_PARAMS = "\
    useradd -P '' -s /bin/bash -m main; \
"