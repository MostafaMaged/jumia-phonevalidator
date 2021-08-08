import { PhoneNumber } from "./PhoneNumber";

export class PhoneNumberResponse {
    constructor(
        public phoneNumbers: PhoneNumber[],
        public last: Boolean,
        public totalPages: number,
        public first: Boolean,
        public number: number
    ) {

    }
}